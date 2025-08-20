package edu.famous.E_Commerce_Product_Search.config;

import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;

@Configuration
public class SolrConfig {

    @Value("${spring.data.solr.host}")
    private String solrUrl;

    @Value("${spring.data.solr.core}")
    private String solrCoreName;

    @Bean
    public SolrClient solrClient() {
        return new org.apache.solr.client.solrj.impl.HttpSolrClient.Builder(solrUrl + "/" + solrCoreName)
                .build();
    }

    // Additional Solr configuration beans can be added here if needed
    // For example, you can define a SolrTemplate bean if you need to use it
     @Bean
     public SolrTemplate solrTemplate(SolrClient solrClient) {
         return new SolrTemplate(solrClient);
     }
    // You can also define a SolrRepositoryFactoryBean if you need to create repositories
    // @Bean
    // public SolrRepositoryFactoryBean solrRepositoryFactoryBean(SolrClient solrClient) {
    //     return new SolrRepositoryFactoryBean(solrClient);
    // }
}
