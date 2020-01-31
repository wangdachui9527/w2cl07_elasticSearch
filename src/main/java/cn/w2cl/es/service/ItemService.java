package cn.w2cl.es.service;

import cn.w2cl.es.pojo.Item;

import java.util.List;

/**
 * @Authror 卫骏
 * @Date 2020/1/31 14:41
 */
public interface ItemService {
    /**
     * 新增/修改
     * @param item
     */
    void save(Item item);

    /**
     * 删除
     * @param item
     */
    void delete(Item item);

    /**
     * 批量新增
     * @param list
     */
    void saveAll(List<Item> list);
}
