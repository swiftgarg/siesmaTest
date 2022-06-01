package com.example.siesmaTest;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StreamUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class SiesmaS3Connector {


    public String s3Connector() throws IOException, ClassNotFoundException {
        AWSCredentials credentials = null;
//        try {
//            credentials = new ProfileCredentialsProvider().getCredentials();
//        } catch (Exception e) {
//            throw new AmazonClientException(
//                    "Cannot load the credentials from the credential profiles file. " +
//                            "Please make sure that your credentials file is at the correct " +
//                            "location (~/.aws/credentials), and is in valid format.",
//                    e);
//        }

     //   BufferedInputStream in = new BufferedInputStream(new URL("http://localhost:4566/siesmataxslabs/taxSlabs.json").openStream());

        AmazonS3 s3 = AmazonS3ClientBuilder.standard()
               // .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:4566/","us-west-2"))
              //  .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion("us-west-2")
                .build();

         String s3ObjectAsString =  s3.getObjectAsString("siesmataxslabs", "taxSlabs.json");

        //      return in.toString();
        return  s3ObjectAsString;
    }
}
