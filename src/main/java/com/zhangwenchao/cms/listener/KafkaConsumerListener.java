/*package com.zhangwenchao.cms.listener;

import java.util.List;

import javax.annotation.Resource;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.zhangwenchao.cms.pojo.Article;
import com.zhangwenchao.cms.service.ArticleService;


@Component
public class KafkaConsumerListener implements MessageListener<String, String>{

	@Resource
	private ArticleService articleService;
	@Autowired
	private RedisTemplate redisTemplate;
	@Override
	public void onMessage(ConsumerRecord<String, String> record) {
		String key = record.key();
		
		//判断key值内容
		if(key != null && key.equals("article_add")) {
			//添加数据
			
			//获取value
			String json = record.value();
			
			//将json转换成实体类对象
			Article article = JSON.parseObject(json, Article.class);
			
			//将数据存入到数据库
			int kafkaSave = articleService.kafkaSave(article);
			
			System.out.println(kafkaSave + "=====" + article);
		}
		if(key!=null&&key.equals("articleAdd")) {
			String value = record.value();
			Gson g=new Gson();
			articleService.kafkaSave(g.fromJson(value, Article.class));
		}
		
		if(key!=null && key.equals("addArticle")) {
			String value = record.value();
			Gson g=new Gson();
			Article a = g.fromJson(value,Article.class);
			int kafkaSave = articleService.kafkaSave(a);
			if(kafkaSave>0) {
				System.err.println("添加成功");
			}
		}
		if(key!=null && key.equals("redis_key")) {
			String value = record.value();
			ListOperations opsForList = redisTemplate.opsForList();
			List<Article> list = opsForList.range(value,0, -1);
			for (Article article : list) {
				int kafkaSave = articleService.kafkaSave(article);
				if(kafkaSave>0) {
					System.err.println(article.getTitle()+"添加成功");
					opsForList.remove(value, 0, article);
				}
			}
		}
	}

}
*/