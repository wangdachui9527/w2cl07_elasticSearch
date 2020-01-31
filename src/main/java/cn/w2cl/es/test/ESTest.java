package cn.w2cl.es.test;


import cn.w2cl.es.pojo.Item;
import cn.w2cl.es.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
        item.setId(19);
        item.setTitle("学习Elasticsearch");
        item.setContent("努力学习 使用SpringData ES 完成搜索功能");
        this.itemService.save(item);
    }

    //删除
    @Test
    public void testDelete(){
        Item item = new Item();
        item.setId(100);
        this.itemService.delete(item);
    }

    //删除所有
    @Test
    public void testDeleteAll(){
        this.itemService.deleteAll();
    }

    //批量保存
    @Test
    public void testSaveAll(){
        List<Item> list = new ArrayList<Item>();
        for(int i = 1 ; i <= 100; i++){
            Item item = new Item();
            item.setId(i);
            item.setTitle("SpringData ES " + i);
            item.setContent("今天我们使用SpringData ES完成job搜索功能。" + i);
            list.add(item);
        }
        this.itemService.saveAll(list);
    }

    //普通查询所有
    @Test
    public void testFindAll(){
        Iterable<Item> all = this.itemService.findAll();
        for (Item item : all) {
            System.out.println(item);
        }
    }


    //分页查询
    //注意分页的page是从0开始查询的，为了方便理解，已经在dao层的参数中进行了-1操作
    @Test
    public void testFindAllByPage(){
        Page<Item> byPage = this.itemService.findByPage(2, 10);
        List<Item> content = byPage.getContent();
        for (Item item : content) {
            System.out.println(item);
        }
    }

    //复杂查询
    //复杂查询需要注意方法名称的命名方式  and or 等
    //根据title和content来交集查询
    @Test
    public void testFindByTitleAndContent(){
        List<Item> list = this.itemService.findByTitleAndContent("SpringData ES","今天我们使用SpringData ES完成job搜索功能。");
        for (Item item : list) {
            System.out.println(item);
        }
    }

    //根据title和content来并集查询
    @Test
    public void testFindByTitleOrContent(){
        List<Item> list = this.itemService.findByTitleOrContent("22","23",1,5);
        for (Item item : list) {
            System.out.println(item);
        }
    }

    //根据title和content以及id的范围来交集分页查询
    @Test
    public void testFindByTitleAndContentAndIdBetween(){
        List<Item> list = this.itemService.findByTitleAndContentAndIdBetween("ES","搜索",11,17,1,10);
        for (Item item : list) {
            System.out.println(item);
        }
    }
}
