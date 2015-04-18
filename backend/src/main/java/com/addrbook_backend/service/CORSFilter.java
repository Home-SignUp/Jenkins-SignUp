//package com.addrbook.service;
//
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created by alexandr on 30.03.15.
// *
// * ( http://krams915.blogspot.com/2010/12/spring-security-mvc-implementing-single.html )
// * ( https://github.com/spring-projects/spring-test-mvc ** https://github.com/spring-projects/spring-test-mvc/tree/master/src/test/java/org/springframework/test/web )
// * ( http://www.objectpartners.com/2011/06/16/implementing-rest-authentication/ )
// * ( https://github.com/draptik/angulardemorestful )
// * ( http://en.wikipedia.org/wiki/Cross-origin_resource_sharing )
// * http://draptik.github.io/blog/2013/08/19/angularjs-and-cors/
// * http://ru.vingrad.com/Spring-Hibernate-id50bb5e7e6ccc1948220056bc
// * https://gist.github.com/zeroows/80bbe076d15cb8a4f0ad
// * http://zhentao-li.blogspot.com/2013/06/example-for-enabling-cors-support-in.html
// * http://www.blog.btbw.pl/java/spring-mvc-angularjs-not-allowed-by-access-control-allow-origin/
// * http://patrickgrimard.com/2013/12/12/cross-origin-resource-sharing-cors-requests-with-spring-mvc/
// * http://zhentao-li.blogspot.com/2013/06/example-for-enabling-cors-support-in.html
// */
//public class CORSFilter extends OncePerRequestFilter {
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        response.addHeader("Access-Control-Allow-Credentials", "true");
////        MDCSession.setSessionId(request.getHeader(Constants.Cookies.SESSION_ID));
//        response.addHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
//        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE,OPTIONS");
//        response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with, Authorization, X-Scheme");
//        response.setHeader("Pragma", "no-cache");
//        response.setHeader("Cache-Control", "must-revalidate");
//        response.setHeader("Cache-Control", "no-cache");
//        response.setHeader("Cache-Control", "no-store");
//        response.setDateHeader("Expires", 0);
//        filterChain.doFilter(request, response);
//    }
//
//}
