import com.xgit.boot.BlogApplication;
import com.xgit.boot.mapper.MBlogMapper;
import com.xgit.boot.mapper.MUserMapper;
import com.xgit.boot.service.MBlogService;
import com.xgit.boot.service.MUserService;
import com.xgit.boot.service.impl.MUserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by tianxuanxuan
 * On 2020-09-12 20:11
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogApplication.class)
public class MyBlogTest {
    @Autowired
    private MUserMapper mUserMapper;

    @Autowired
    private MBlogMapper mBlogMapper;

    @Autowired
    private MUserService mUserService;


    @Test
    public void testUser(){
        System.out.println(("----- selectAll method test ------"));
        System.out.println(mUserMapper.selectList(null));
    }

    @Test
    public void testBlog(){
        System.out.println(("----- selectAll method test ------"));
        System.out.println(mBlogMapper.selectList(null));
    }

    @Test
    public void testUserService(){
        System.out.println("---- select userService -----");
        System.out.println(mUserService.list());
    }
}
