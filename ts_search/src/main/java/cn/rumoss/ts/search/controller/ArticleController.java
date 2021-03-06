package cn.rumoss.ts.search.controller;

import cn.rumoss.ts.entity.PageResult;
import cn.rumoss.ts.entity.Result;
import cn.rumoss.ts.entity.StatusCode;
import cn.rumoss.ts.search.pojo.Article;
import cn.rumoss.ts.search.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 添加文章
     * @param article
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Article article){
        articleService.add(article);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    /**
     * 根据关键字查询
     * @param keyswords
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/search/{keyswords}/{page}/{size}", method = RequestMethod.GET)
    public Result findByKeywords(@PathVariable String keyswords, @PathVariable int page, @PathVariable int size){
        PageResult pageResult = articleService.findByKeywords(keyswords, page, size);
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }
}
