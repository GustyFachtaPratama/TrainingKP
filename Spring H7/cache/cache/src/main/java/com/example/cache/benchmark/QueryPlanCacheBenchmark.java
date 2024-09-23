//package com.example.cache.benchmark;
//
//import com.example.cache.util.HibernateUtil;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.jpa.QueryHints;
//import org.hibernate.query.Query;
//import org.openjdk.jmh.annotations.*;
//import org.openjdk.jmh.infra.Blackhole;
//
//import java.io.IOException;
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//
//@State(Scope.Thread)
//public class QueryPlanCacheBenchmark {
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
//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//    @OutputTimeUnit(TimeUnit.MICROSECONDS)
//    @Fork(1)
//    @Warmup(iterations = 2)
//    @Measurement(iterations = 5)
//    public void givenQueryPlanCacheSize_thenCompileQueries(Blackhole blackhole) {
//        Query query1 = findEmployeesByDepartmentNameQuery(session);
//        Query query2 = findEmployeesByDesignationQuery(session);
//        Query query3 = findDepartmentOfAnEmployeeQuery(session);
//
//        blackhole.consume(query1);
//        blackhole.consume(query2);
//        blackhole.consume(query3);
//    }
//
//    private Query findEmployeesByDepartmentNameQuery(Session session) {
//        session.createQuery("SELECT e FROM DeptEmployee e " +
//                        "JOIN e.department WHERE e.department.name = :deptName")
//                .setMaxResults(30)
//                .setHint(QueryHints.HINT_FETCH_SIZE, 30);
//        return null;
//    }
//
//    private Query findEmployeesByDesignationQuery(Session session) {
//        session.createQuery("SELECT e.department FROM DeptEmployee e " +
//                "JOIN e.department WHERE e.employeeNumber = :empId");
//        return null;
//    }
//
//    private Query findDepartmentOfAnEmployeeQuery(Session session) {
//        session.createQuery("SELECT e FROM DeptEmployee e " + "WHERE e.title = :designation").setHint(QueryHints.SPEC_HINT_TIMEOUT, 1000);
//        return null;
//    }
//
//    @TearDown
//    public void tearDown() {
//        if (session != null && session.isOpen()) {
//            session.close();
//        }
//    }
//}
