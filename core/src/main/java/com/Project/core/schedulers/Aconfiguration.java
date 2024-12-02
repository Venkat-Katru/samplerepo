package com.Project.core.schedulers;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Task10 Scheduler Configuration", description = "Configuration for Task10 scheduler")
public @interface Aconfiguration {

    @AttributeDefinition(
        name = "Enable Scheduler",
        description = "Enable or disable the scheduler."
    )
    boolean enable() default true;

    @AttributeDefinition(
        name = "Scheduler Cron Expression",
        description = "Cron expression to control the execution interval of the scheduler."
    )
    String schedulerExpression() default "0 */59 * * * ?";
}
