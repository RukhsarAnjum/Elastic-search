package com.example.elasticsearch;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
@Component
@SpringBootApplication
@ConfigurationPropertiesScan("com.example.elasticsearch")
public class SpringBootUsingElasticSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUsingElasticSearchApplication.class, args);
	}

	@Bean
	public boolean createTestIndex(RestHighLevelClient restHighLevelClient) throws Exception {
		try {
			DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("hello-world");
			restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
		} catch (Exception ignored) {
		}

		CreateIndexRequest createIndexRequest = new CreateIndexRequest("hello-world");
		createIndexRequest.settings(
				Settings.builder().put("index.number_of_shards", 1)
						.put("index.number_of_replicas", 0));
		restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);

		return true;
	}
}