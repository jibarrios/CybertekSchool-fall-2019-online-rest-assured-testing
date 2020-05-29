package com.automation.tests.day9;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

public class BadSSL {


    @Test
    public void badSSLCertificateTest(){
        /**
         * no valid certificate - no handshake, no secure connection
         *     relaxedHTTPSValidation - ignore SSL certificate issues
         *      * Use relaxed HTTP validation with SSLContext protocol SSL.
         *      This means that you'll trust all hosts regardless if the SSL certificate is invalid.
         *      By using this method you don't need to specify a keystore or trust store.
         */
        baseURI = "https://untrusted-root.badssl.com/";
        Response response = given().relaxedHTTPSValidation().get().prettyPeek();
        System.out.println(response.statusCode());

    }
}
