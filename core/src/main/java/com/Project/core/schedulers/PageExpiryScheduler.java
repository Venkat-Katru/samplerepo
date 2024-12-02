package com.Project.core.schedulers;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.query.Query;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Component(service = Runnable.class, immediate = true, configurationPolicy = ConfigurationPolicy.REQUIRE)
@Designate(ocd = PageExpiryScheduler.Config.class)
public class PageExpiryScheduler implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger("com.Project.core"); // Custom logger

    @Reference
    private ResourceResolverService resourceResolverService;

    @Override
    public void run() {
        try (ResourceResolver resolver = resourceResolverService.createWriter()) {
            if (resolver != null) {
                String query = "SELECT * FROM [nt:base] WHERE ISDESCENDANTNODE('/content') AND [expiryDate] IS NOT NULL";
                @SuppressWarnings("unchecked")
                List<Resource> pages = (List<Resource>) resolver.findResources(query, Query.JCR_SQL2);

                Calendar now = new GregorianCalendar();

                for (Resource page : pages) {
                    ValueMap properties = page.adaptTo(ValueMap.class);
                    Calendar expiryDate = properties.get("expiryDate", Calendar.class);

                    if (expiryDate != null) {
                        if (expiryDate.after(now)) {
                            publishPage(page);
                        } else {
                            unpublishPage(page);
                        }
                    }
                }
            } else {
                LOG.error("Unable to obtain ResourceResolver.");
            }
        } catch (Exception e) {
            LOG.error("Error occurred in PageExpiryScheduler: ", e);
        }
    }

    private void publishPage(Resource page) {
        try {
            Session session = page.getResourceResolver().adaptTo(Session.class);
            if (session != null) {
                String path = page.getPath();
                if (session.hasPermission(path, "jcr:write")) {
                    session.getWorkspace().getVersionManager().checkin(path);
                    LOG.info("Published page: {}", path); // Log publishing
                } else {
                    LOG.warn("No write permission for path: {}", path);
                }
            } else {
                LOG.error("JCR Session is null for path: {}", page.getPath());
            }
        } catch (RepositoryException e) {
            LOG.error("Error publishing page: {}", page.getPath(), e);
        }
    }

    private void unpublishPage(Resource page) {
        try {
            Session session = page.getResourceResolver().adaptTo(Session.class);
            if (session != null) {
                String path = page.getPath();
                if (session.hasPermission(path, "jcr:write")) {
                    session.getWorkspace().getVersionManager().checkout(path);
                    LOG.info("Unpublished page: {}", path); // Log unpublishing
                } else {
                    LOG.warn("No write permission for path: {}", path);
                }
            } else {
                LOG.error("JCR Session is null for path: {}", page.getPath());
            }
        } catch (RepositoryException e) {
            LOG.error("Error unpublishing page: {}", page.getPath(), e);
        }
    }

    @ObjectClassDefinition(name = "Page Expiry Scheduler Configuration")
    public @interface Config {
        @AttributeDefinition(name = "Cron Expression", description = "Cron expression for scheduler")
        String cronExpression() default "0 0/3 * * * ?"; // Executes every 3 minutes
    }

    public interface ResourceResolverService {
        ResourceResolver createWriter();
    }
}
