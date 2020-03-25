**说明**
> 本项目为基于Quartz实现的可动态配置的任务管理器基础功能，本质上Quartz只可控制到线程级别，为了符合实际生产使用，内部结合了Mysql数据库进行了记录，从而达到的最终效果为可对每一个任务进行记录，并在项目启动时自动读取所记录的任务进行工作。

> 注:此版本只包含Quartz控制线程来实现任务动态控制的基础功能，数据库只起到项目启动时自动添加一个任务并进行执行的辅助作用

> 补充:目前还存在一些可见的缺失，后期补充  
        1.维护数据库内容，可达到数据库与Quartz创建的现成达到完全同步
        2.多分部署存在定时器多次执行或关闭定时器失效问题，可通过MQ的发布订阅模式来统一管理线程，在通过版本控制锁来进行任务并发多执行问题
        
**环境** 
> (1).JDK1.8(需要8以及以上版本)  
  (2).gradle4.5(4.0以上即可)

**使用**

> (1)需拷贝如下文件(基础)  
      1.com->beyondli->common->config->job->JobConfigration(基础配置)
      2.com->beyondli->common->config->job->JobFactory(工厂配置)
      3.com->beyondli->common->config->job->JobManager(任务CURD工具类)
      4.com->beyondli->common->config->job->ScheduleJobInitListener(项目启动时自动将数据库现有任务进行录入并启动使用)  
      5.com->beyondli->repository->job->JobQueryMapper(4.ScheduleJobInitListener使用)
      6.com->beyondli->entity->po->job->JobInfoPO(4.ScheduleJobInitListener使用)
      7.com->beyondli->entity->enums->job->JobStatus(6.JobInfoPO使用)
      8.com->beyondli->common->tools->job->TestJob(这里的每一个类对应每一个Job的业务逻辑,有多套就写多个,这里只有一个并与数据库的一条数据做对应)
      
> (2)需拷贝如下文件(业务接口<非必须>)  
      1.com->beyondli->controller->job->JobController(提供了任务CURD功能)  
      2.com->beyondli->entity->job->`*`(1.JobController使用)  
      3.com->beyondli->service->job->`*`(1.JobController对应的业务层)
        
> (3) 添加依赖  
    compile 'org.quartz-scheduler:quartz:2.2.1'  
    compile group: 'org.springframework', name: 'spring-context-support', version: '5.1.7.RELEASE'
    
> (4) 执行resources->schema-quartz.sql中的sql，其中包含表结构和一条数据，该数据对应的即(1)中8的内容