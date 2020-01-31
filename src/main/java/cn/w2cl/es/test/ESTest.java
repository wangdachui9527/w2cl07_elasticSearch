package cn.w2cl.es.test;


import cn.w2cl.es.pojo.Item;
import cn.w2cl.es.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Authror 卫骏
 * @Date 2020/1/31 15:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ESTest {

    @Autowired
    private ItemService itemService;
    @Autowired
    private ElasticsearchTemplate template;

    //创建索引和映射
    @Test
    public void createIndex(){
        this.template.createIndex(Item.class);
        this.template.putMapping(Item.class);
    }
    //新增
    @Test
    public void testSave(){
        Item item = new Item();
        item.setId(100);
        item.setTitle("学习Elasticsearch");
        item.setContent("使用SpringData ES 完成搜索功能");
        itemService.save(item);
    }
    //修改 和新增代码是一样的，只是通过id来判断是新增还是修改，如果item的id已经在索引库中存在，那么就是修改，否则就是新增
    @Test
    public void testModify(){
        Item item = new Item();
        item.setId(100);
        item.setTitle("学习Elasticsearch");
        item.setContent("自学 使用SpringData ES 完成搜索功能");
        this.itemService.save(item);
    }

    //删除
    @Test
    public void testDelete(){
        Item item = new Item();
        item.setId(100);
        this.itemService.delete(item);
    }

    //批量保存
    @Test
    public void testSaveAll(){
        List<Item> list = new ArrayList<Item>();
        for(int i = 1 ; i <= 100; i++){
            Item item = new Item();
            item.setId(i);
            item.setTitle("学习Elasticsearch" + i);
            item.setContent("自学 使用SpringData ES 完成搜索功能" + i);
            list.add(item);
        }
        this.itemService.saveAll(list);
    }


}
