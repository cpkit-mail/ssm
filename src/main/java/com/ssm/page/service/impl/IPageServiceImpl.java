package com.ssm.page.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.page.dao.PageMapper;
import com.ssm.page.model.PageModel;
import com.ssm.page.service.IPageService;

/**
 * 
 * 数据分页
 *
 */
@Service("pageService")
public class IPageServiceImpl implements IPageService {

    @Resource
    private PageMapper pageMapper;

    @Override
    public List<PageModel> getAllUser() {

        // 获取第1页，10条内容，默认查询总数count
        PageHelper.startPage(1, 10);
        List<PageModel> list = pageMapper.getAllUser();
        // 20是导航页码数，表示对多显示20个，默认是8个
        // 比如有10页，设置20时导航范围就是FirstPage:1-LastPage:10；设置5时导航范围就是FirstPage:1-LastPage:5。
        // PageInfo<User> page = new PageInfo<User>(list, 20);
        PageInfo<PageModel> page = new PageInfo<PageModel>(list);
        int piPageNum = page.getPageNum();
        int piPageSize = page.getPageSize();
        int piStartRow = page.getStartRow();
        int piEndRow = page.getEndRow();
        long piTotal = page.getTotal();
        int piPages = page.getPages();
        int piFirstPage = page.getFirstPage();
        int piLastPage = page.getLastPage();
        boolean piIsFirstPage = page.isIsFirstPage();
        boolean piIsLastPage = page.isIsLastPage();
        boolean piHasPreviousPage = page.isHasPreviousPage();
        boolean piHasNextPage = page.isHasNextPage();

        return page.getList();
    }

    
//
//    /**
//     * 使用Mapper接口调用时，使用PageHelper.startPage效果更好，不需要添加Mapper接口参数
//     */
//    @Test
//    public void testMapperWithStartPage() {
//        SqlSession sqlSession = MybatisHelper.getSqlSession();
//        CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
//        try {
//            //获取第1页，10条内容，默认查询总数count
//            PageHelper.startPage(1, 10, "id desc");
//            List<Country> list = countryMapper.selectAll();
//            assertEquals(10, list.size());
//            assertEquals(183, ((Page<?>) list).getTotal());
//
//
//            //获取第2页，10条内容，显式查询总数count
//            PageHelper.orderBy("countryname desc");
//            list = countryMapper.selectAll();
//            assertEquals(183, list.size());
//            assertEquals(183, ((Page<?>) list).getTotal());
//
//
//            //获取第2页，10条内容，不查询总数count
//            PageHelper.startPage(2, 10, false);
//            PageHelper.orderBy("id asc");
//            list = countryMapper.selectAll();
//            assertEquals(10, list.size());
//            assertEquals(-1, ((Page<?>) list).getTotal());
//
//
//            //获取第3页，20条内容，默认查询总数count
//            PageHelper.orderBy("countryname desc");
//            PageHelper.startPage(3, 20);
//            list = countryMapper.selectAll();
//            assertEquals(20, list.size());
//            assertEquals(183, ((Page<?>) list).getTotal());
//        } finally {
//            sqlSession.close();
//        }
//    }
//
//    /**
//     * 使用Mapper接口调用时，对接口增加RowBounds参数，不需要修改对应的xml配置（或注解配置）
//     * <p/>
//     * RowBounds方式不进行count查询，可以通过修改Page代码实现
//     * <p/>
//     * 这种情况下如果同时使用startPage方法，以startPage为准
//     */
//    @Test
//    public void testMapperWithRowBounds() {
//        SqlSession sqlSession = MybatisHelper.getSqlSession();
//        CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
//        try {
//            //获取第1页，10条内容，默认查询总数count
//            List<Country> list = countryMapper.selectAll(new RowBounds(0, 10));
//            assertEquals(10, list.size());
//            assertEquals(-1, ((Page<?>) list).getTotal());
//            //判断查询结果的位置是否正确
//            assertEquals(1, list.get(0).getId());
//            assertEquals(10, list.get(list.size() - 1).getId());
//
//
//            //获取第2页，10条内容，显式查询总数count
//            list = countryMapper.selectAll(new RowBounds(10, 10));
//            assertEquals(10, list.size());
//            assertEquals(-1, ((Page<?>) list).getTotal());
//            //判断查询结果的位置是否正确
//            assertEquals(11, list.get(0).getId());
//            assertEquals(20, list.get(list.size() - 1).getId());
//
//
//            //获取第3页，20条内容，默认查询总数count
//            list = countryMapper.selectAll(new RowBounds(60, 20));
//            assertEquals(20, list.size());
//            assertEquals(-1, ((Page<?>) list).getTotal());
//            //判断查询结果的位置是否正确
//            assertEquals(61, list.get(0).getId());
//            assertEquals(80, list.get(list.size() - 1).getId());
//
//
//            //同时使用startPage和RowBounds时，以startPage为准
//            PageHelper.startPage(1, 20);
//            list = countryMapper.selectAll(new RowBounds(60, 20));
//            assertEquals(20, list.size());
//            assertEquals(183, ((Page<?>) list).getTotal());
//            //判断查询结果的位置是否正确
//            assertEquals(1, list.get(0).getId());
//            assertEquals(20, list.get(list.size() - 1).getId());
//        } finally {
//            sqlSession.close();
//        }
//    }
//
//    /**
//     * 使用命名空间调用时，使用PageHelper.startPage
//     * <p/>
//     * startPage第三个参数可以控制是(true)否(false)执行count查询，使用两个查询的startPage时默认进行count查询
//     * <p/>
//     * 使用startPage方法时，如果同时使用RowBounds，以startPage为准
//     */
//    @Test
//    public void testNamespaceWithStartPage() {
//        SqlSession sqlSession = MybatisHelper.getSqlSession();
//
//        try {
//            //获取第1页，10条内容，默认查询总数count
//            PageHelper.startPage(1, 10);
//            List<Country> list = sqlSession.selectList("selectAll");
//            assertEquals(10, list.size());
//            assertEquals(183, ((Page<?>) list).getTotal());
//
//            //获取第2页，10条内容，显式查询总数count
//            PageHelper.startPage(2, 10, true);
//            list = sqlSession.selectList("selectAll");
//            assertEquals(10, list.size());
//            assertEquals(183, ((Page<?>) list).getTotal());
//
//            //获取第2页，10条内容，不查询总数count
//            PageHelper.startPage(2, 10, false);
//            list = sqlSession.selectList("selectAll");
//            assertEquals(10, list.size());
//            assertEquals(-1, ((Page<?>) list).getTotal());
//
//            //获取第3页，20条内容，默认查询总数count
//            PageHelper.startPage(3, 20);
//            list = sqlSession.selectList("selectAll");
//            assertEquals(20, list.size());
//            assertEquals(183, ((Page<?>) list).getTotal());
//        } finally {
//            sqlSession.close();
//        }
//    }
//
//    /**
//     * 使用命名空间方式的RowBounds进行分页，使用RowBounds时不进行count查询
//     * 通过修改代码可以进行count查询，没法通过其他方法改变参数
//     * 因为如果通过调用一个别的方法来标记count查询，还不如直接startPage
//     * <p/>
//     * 同时使用startPage时，以startPage为准，会根据startPage参数来查询
//     */
//    @Test
//    public void testNamespaceWithRowBounds() {
//        SqlSession sqlSession = MybatisHelper.getSqlSession();
//        try {
//            //获取从0开始，10条内容
//            List<Country> list = sqlSession.selectList("selectAll", null, new RowBounds(0, 10));
//            assertEquals(10, list.size());
//            assertEquals(-1, ((Page<?>) list).getTotal());
//            //判断查询结果的位置是否正确
//            assertEquals(1, list.get(0).getId());
//            assertEquals(10, list.get(list.size() - 1).getId());
//
//
//            //获取从10开始，10条内容
//            list = sqlSession.selectList("selectAll", null, new RowBounds(10, 10));
//            assertEquals(10, list.size());
//            assertEquals(-1, ((Page<?>) list).getTotal());
//            //判断查询结果的位置是否正确
//            assertEquals(11, list.get(0).getId());
//            assertEquals(20, list.get(list.size() - 1).getId());
//
//
//            //获取从20开始，20条内容
//            list = sqlSession.selectList("selectAll", null, new RowBounds(20, 20));
//            assertEquals(20, list.size());
//            assertEquals(-1, ((Page<?>) list).getTotal());
//            //判断查询结果的位置是否正确
//            assertEquals(21, list.get(0).getId());
//            assertEquals(40, list.get(list.size() - 1).getId());
//
//
//            //同时使用startPage和RowBounds时，以startPage为准
//            PageHelper.startPage(1, 20);
//            list = sqlSession.selectList("selectAll", null, new RowBounds(0, 10));
//            assertEquals(20, list.size());
//            assertEquals(183, ((Page<?>) list).getTotal());
//            //判断查询结果的位置是否正确
//            assertEquals(1, list.get(0).getId());
//            assertEquals(20, list.get(list.size() - 1).getId());
//        } finally {
//            sqlSession.close();
//        }
//    }
//    
//
//    /**
//     * 使用Mapper接口调用时，使用PageHelper.startPage效果更好，不需要添加Mapper接口参数
//     */
//    @Test
//    public void testPageSize10() {
//        SqlSession sqlSession = MybatisHelper.getSqlSession();
//        CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
//        try {
//            //获取第1页，10条内容，默认查询总数count
//            PageHelper.startPage(1, 10);
//            List<Country> list = countryMapper.selectAll();
//            PageInfo<Country> page = new PageInfo<Country>(list);
//            assertEquals(1, page.getPageNum());
//            assertEquals(10, page.getPageSize());
//            assertEquals(1, page.getStartRow());
//            assertEquals(10, page.getEndRow());
//            assertEquals(183, page.getTotal());
//            assertEquals(19, page.getPages());
//            assertEquals(1, page.getFirstPage());
//            assertEquals(8, page.getLastPage());
//            assertEquals(true, page.isIsFirstPage());
//            assertEquals(false, page.isIsLastPage());
//            assertEquals(false, page.isHasPreviousPage());
//            assertEquals(true, page.isHasNextPage());
//
//
//            //获取第2页，10条内容，默认查询总数count
//            PageHelper.startPage(2, 10);
//            list = countryMapper.selectAll();
//            page = new PageInfo<Country>(list);
//            assertEquals(2, page.getPageNum());
//            assertEquals(10, page.getPageSize());
//            assertEquals(11, page.getStartRow());
//            assertEquals(20, page.getEndRow());
//            assertEquals(183, page.getTotal());
//            assertEquals(19, page.getPages());
//            assertEquals(1, page.getFirstPage());
//            assertEquals(8, page.getLastPage());
//            assertEquals(false, page.isIsFirstPage());
//            assertEquals(false, page.isIsLastPage());
//            assertEquals(true, page.isHasPreviousPage());
//            assertEquals(true, page.isHasNextPage());
//
//
//            //获取第19页，10条内容，默认查询总数count
//            PageHelper.startPage(19, 10);
//            list = countryMapper.selectAll();
//            page = new PageInfo<Country>(list);
//            assertEquals(19, page.getPageNum());
//            assertEquals(10, page.getPageSize());
//            assertEquals(181, page.getStartRow());
//            assertEquals(183, page.getEndRow());
//            assertEquals(183, page.getTotal());
//            assertEquals(19, page.getPages());
//            assertEquals(12, page.getFirstPage());
//            assertEquals(19, page.getLastPage());
//            assertEquals(false, page.isIsFirstPage());
//            assertEquals(true, page.isIsLastPage());
//            assertEquals(true, page.isHasPreviousPage());
//            assertEquals(false, page.isHasNextPage());
//
//        } finally {
//            sqlSession.close();
//        }
//    }
//
//
//    /**
//     * 使用Mapper接口调用时，使用PageHelper.startPage效果更好，不需要添加Mapper接口参数
//     */
//    @Test
//    public void testPageSize50() {
//        SqlSession sqlSession = MybatisHelper.getSqlSession();
//        CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
//        try {
//            //获取第1页，50条内容，默认查询总数count
//            PageHelper.startPage(1, 50);
//            List<Country> list = countryMapper.selectAll();
//            PageInfo<Country> page = new PageInfo<Country>(list);
//            assertEquals(1, page.getPageNum());
//            assertEquals(50, page.getPageSize());
//            assertEquals(1, page.getStartRow());
//            assertEquals(50, page.getEndRow());
//            assertEquals(183, page.getTotal());
//            assertEquals(4, page.getPages());
//            assertEquals(1, page.getFirstPage());
//            assertEquals(4, page.getLastPage());
//            assertEquals(true, page.isIsFirstPage());
//            assertEquals(false, page.isIsLastPage());
//            assertEquals(false, page.isHasPreviousPage());
//            assertEquals(true, page.isHasNextPage());
//
//
//            //获取第2页，50条内容，默认查询总数count
//            PageHelper.startPage(2, 50);
//            list = countryMapper.selectAll();
//            page = new PageInfo<Country>(list);
//            assertEquals(2, page.getPageNum());
//            assertEquals(50, page.getPageSize());
//            assertEquals(51, page.getStartRow());
//            assertEquals(100, page.getEndRow());
//            assertEquals(183, page.getTotal());
//            assertEquals(4, page.getPages());
//            assertEquals(1, page.getFirstPage());
//            assertEquals(4, page.getLastPage());
//            assertEquals(false, page.isIsFirstPage());
//            assertEquals(false, page.isIsLastPage());
//            assertEquals(true, page.isHasPreviousPage());
//            assertEquals(true, page.isHasNextPage());
//
//            //获取第3页，50条内容，默认查询总数count
//            PageHelper.startPage(3, 50);
//            list = countryMapper.selectAll();
//            page = new PageInfo<Country>(list);
//            assertEquals(3, page.getPageNum());
//            assertEquals(50, page.getPageSize());
//            assertEquals(101, page.getStartRow());
//            assertEquals(150, page.getEndRow());
//            assertEquals(183, page.getTotal());
//            assertEquals(4, page.getPages());
//            assertEquals(1, page.getFirstPage());
//            assertEquals(4, page.getLastPage());
//            assertEquals(false, page.isIsFirstPage());
//            assertEquals(false, page.isIsLastPage());
//            assertEquals(true, page.isHasPreviousPage());
//            assertEquals(true, page.isHasNextPage());
//
//
//            //获取第4页，50条内容，默认查询总数count
//            PageHelper.startPage(4, 50);
//            list = countryMapper.selectAll();
//            page = new PageInfo<Country>(list);
//            assertEquals(4, page.getPageNum());
//            assertEquals(50, page.getPageSize());
//            assertEquals(151, page.getStartRow());
//            assertEquals(183, page.getEndRow());
//            assertEquals(183, page.getTotal());
//            assertEquals(4, page.getPages());
//            assertEquals(1, page.getFirstPage());
//            assertEquals(4, page.getLastPage());
//            assertEquals(false, page.isIsFirstPage());
//            assertEquals(true, page.isIsLastPage());
//            assertEquals(true, page.isHasPreviousPage());
//            assertEquals(false, page.isHasNextPage());
//
//        } finally {
//            sqlSession.close();
//        }
//    }
//
//
//    /**
//     * 使用Mapper接口调用时，使用PageHelper.startPage效果更好，不需要添加Mapper接口参数
//     */
//    @Test
//    public void testNavigatePages() {
//        SqlSession sqlSession = MybatisHelper.getSqlSession();
//        CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
//        try {
//            //获取第1页，10条内容，默认查询总数count
//            PageHelper.startPage(1, 10);
//            List<Country> list = countryMapper.selectAll();
//            PageInfo<Country> page = new PageInfo<Country>(list, 20);
//            assertEquals(1, page.getPageNum());
//            assertEquals(10, page.getPageSize());
//            assertEquals(1, page.getStartRow());
//            assertEquals(10, page.getEndRow());
//            assertEquals(183, page.getTotal());
//            assertEquals(19, page.getPages());
//            assertEquals(1, page.getFirstPage());
//            assertEquals(19, page.getLastPage());
//            assertEquals(true, page.isIsFirstPage());
//            assertEquals(false, page.isIsLastPage());
//            assertEquals(false, page.isHasPreviousPage());
//            assertEquals(true, page.isHasNextPage());
//
//            //获取第2页，50条内容，默认查询总数count
//            PageHelper.startPage(2, 50);
//            list = countryMapper.selectAll();
//            page = new PageInfo<Country>(list, 2);
//            assertEquals(2, page.getPageNum());
//            assertEquals(50, page.getPageSize());
//            assertEquals(51, page.getStartRow());
//            assertEquals(100, page.getEndRow());
//            assertEquals(183, page.getTotal());
//            assertEquals(4, page.getPages());
//            assertEquals(1, page.getFirstPage());
//            assertEquals(2, page.getLastPage());
//            assertEquals(false, page.isIsFirstPage());
//            assertEquals(false, page.isIsLastPage());
//            assertEquals(true, page.isHasPreviousPage());
//            assertEquals(true, page.isHasNextPage());
//        } finally {
//            sqlSession.close();
//        }
//    }
    
}
