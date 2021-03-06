package cn.rumoss.ts.search.dao;

import cn.rumoss.ts.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 搜索-文章数据访问层接口
 */
public interface ArticleDao extends ElasticsearchRepository<Article, String> {

    /**
     * 根据文章或者标题模糊查询
     * @param title
     * @param content
     * @param pageable
     * @return
     */
    public Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);

}