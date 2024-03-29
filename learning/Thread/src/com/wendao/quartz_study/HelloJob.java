package com.wendao.quartz_study;

/* 
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved. 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not 
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 * 
 */
 

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * <p>
 * 任务
 * </p>
 * 
 * @author Bill Kratzer
 */
public class HelloJob implements Job {

    public HelloJob() {
    }

   
    public void execute(JobExecutionContext context)
        throws JobExecutionException {
    	System.out.println("------ start -------");
        // Say Hello to the World and display the date/time
        System.out.println("Hello World! - " + new Date());
        System.out.println("------ end -------");
    }

}
