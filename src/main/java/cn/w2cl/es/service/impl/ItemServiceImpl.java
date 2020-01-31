package cn.w2cl.es.service.impl;

import cn.w2cl.es.dao.ItemRepository;
import cn.w2cl.es.pojo.Item;
import cn.w2cl.es.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Authror 卫骏
 * @Date 2020/1/31 14:41
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void save(Item item) {
        itemRepository.save(item);
    }

    public void delete(Item item) {
        this.itemRepository.delete(item);
    }

    public void saveAll(List<Item> list) {
        this.itemRepository.saveAll(list);
    }

    public Iterable<Item> findAll() {
        Iterable<Item> all = this.itemRepository.findAll();
        return all;
    }

    public Page<Item> findByPage(int page, int rows) {

        Page<Item> all = this.itemRepository.findAll(PageRequest.of(page - 1, rows));
        return all;
    }

    public List<Item> findByTitleAndContent(String title, String content) {
        List<Item> byTitleAndContent = this.itemRepository.findByTitleAndContent(title, content);
        return byTitleAndContent;
    }

    public void deleteAll() {
        this.itemRepository.deleteAll();
    }

    public List<Item> findByTitleOrContent(String title, String content, int page, int rows) {
        return this.itemRepository.findByTitleOrContent(title,content,PageRequest.of(page - 1,rows));
    }

    public List<Item> findByTitleAndContentAndIdBetween(String title, String content, int min, int max, int page, int rows) {
        return this.itemRepository.findByTitleAndContentAndIdBetween(title,content,min,max,PageRequest.of(page - 1,rows));
    }


}
