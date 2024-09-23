//package com.example.cache.benchmark;
//
//import com.example.cache.util.HibernateUtil;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.openjdk.jmh.annotations.Param;
//import org.openjdk.jmh.annotations.Setup;
//import org.openjdk.jmh.annotations.State;
//import org.openjdk.jmh.annotations.Scope;
//import java.io.IOException;
//import java.util.Properties;
//
//@State(Scope.Thread)
//public class QueryPlanCacheBenchMarkState {
//
//    @Param({"1", "2", "3"})
//    public int planCacheSize;
//
//    public Session session;
//
//    @Setup
//    public void stateSetup() throws IOException {
//        session = initSession(planCacheSize);
//    }
//
//    private Session initSession(int planCacheSize) throws IOException {
//        Properties properties = HibernateUtil.getProperties();
//        properties.put("hibernate.query.plan_cache_max_size", planCacheSize);
//        properties.put("hibernate.query.plan_parameter_metadata_max_size", planCacheSize);
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactoryByProperties(properties);
//        return sessionFactory.openSession();
//    }
//
//    // Teardown method (optional)
//    // You can add a method here to close the session after the benchmark
//}
