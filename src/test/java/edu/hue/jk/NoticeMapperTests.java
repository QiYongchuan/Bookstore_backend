package edu.hue.jk;


import edu.hue.jk.mapper.NoticeMapper;
import edu.hue.jk.model.Notice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NoticeMapperTests {

    @Autowired
    private NoticeMapper NoticeMapper;

    @Test
    public void test1(){
        List<Notice> noticeList = NoticeMapper.selectAll();
        System.out.println(noticeList);

        Notice notice = new Notice();
        notice.setNId(111);
        notice.setNTime("20230428085900");
        NoticeMapper.insert(notice);


        notice.setTitle("test2");
        NoticeMapper.update(notice);

        NoticeMapper.del(111);
    }
}
