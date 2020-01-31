package cn.w2cl.es.service;

import cn.w2cl.es.pojo.Item;
import org.springframework.data.domain.Page;

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

    /**
     * 查询所有
     * @return
     */
    Iterable<Item> findAll();

    /**
     * 分页查询
     */
    Page<Item> findByPage(int page, int rows);

    /**
     * 复杂交集查询  * @param title
     * @param content
     * @return
     */
    List<Item> findByTitleAndContent(String title, String content);

    void deleteAll();

    /**
     * 复杂分页并集查询
     * @param title
     * @param content
     * @param page
     * @param rows
     * @return
     */
    List<Item> findByTitleOrContent(String title, String content, int page, int rows);

    List<Item> findByTitleAndContentAndIdBetween(String title, String content, int min, int max, int page, int rows);
}
