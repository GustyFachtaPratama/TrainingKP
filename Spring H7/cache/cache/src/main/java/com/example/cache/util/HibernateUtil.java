//package com.example.cache.util;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Properties;
//
//public class HibernateUtil {
//
//    private static SessionFactory sessionFactory;
//
//    public static Properties getProperties() throws IOException {
//        Properties properties = new Properties();
//        try (InputStream input = HibernateUtil.class.getClassLoader().getResourceAsStream("hibernate.properties")) {
//            if (input == null) {
//                throw new IOException("Unable to find hibernate.properties");
//            }
//            properties.load(input);
//        }
//        return properties;
//    }
//
//    public static SessionFactory getSessionFactoryByProperties(Properties properties) {
//        if (sessionFactory == null) {
//            Configuration configuration = new Configuration();
//            configuration.addProperties(properties);
//            sessionFactory = configuration.buildSessionFactory();
//        }
//        return sessionFactory;
//    }
//}
