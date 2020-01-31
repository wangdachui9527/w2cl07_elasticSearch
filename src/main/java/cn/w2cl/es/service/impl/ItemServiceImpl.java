package cn.w2cl.es.service.impl;

import cn.w2cl.es.dao.ItemRepository;
import cn.w2cl.es.pojo.Item;
import cn.w2cl.es.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
