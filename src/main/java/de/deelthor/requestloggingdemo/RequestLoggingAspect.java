package de.deelthor.requestloggingdemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class RequestLoggingAspect {

    private final HttpServletRequest request;

    @Autowired
    public RequestLoggingAspect( final HttpServletRequest request ) {
        this.request = request;
    }

    @Before( "@annotation(LogRequest)" )
    public void logRequest( final JoinPoint joinPoint ) {
        final Logger logger = LoggerFactory.getLogger( joinPoint.getTarget().getClass() );
        final String path = this.request.getRequestURI().substring( this.request.getContextPath().length() );
        logger.info( "Request received as {} {}", this.request.getMethod(), path );
    }
}
