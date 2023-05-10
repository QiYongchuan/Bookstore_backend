package edu.hue.jk.controller;


import edu.hue.jk.mapper.NoticeMapper;
import edu.hue.jk.model.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeMapper noticeMapper;

    @RequestMapping("list")
    public String list(Model model){
        List<Notice> noticeList = noticeMapper.selectAll();
        model.addAttribute(noticeList);

        return "notices/list";
    }

    @RequestMapping("del")
    public String del(Model model,Integer nId){
        noticeMapper.del(nId);

        List<Notice> noticeList = noticeMapper.selectAll();
        model.addAttribute(noticeList);
        return "notices/list";
    }
//    @RequestMapping("add")
//    public String add(Model model , Integer nId){
//         Notice notice = noticeMapper.selectById(nId);
//         model.addAttribute(notice);
//        return "notices/add";
//    }
        @RequestMapping("add")
    public String add(){

        return "notices/add";
    }

    @RequestMapping("edit")
    public String edit(Model model , Integer nId){
        Notice notice = noticeMapper.selectById(nId);
        model.addAttribute(notice);
        return "notices/edit";
    }
    @RequestMapping("save")
    public String save(Model model, Notice notice){
        boolean isNew = noticeMapper.selectById(notice.getNId()) == null;

        if (isNew){
            noticeMapper.insert(notice);
        } else {
            noticeMapper.update(notice);
        }

        List<Notice> noticeList = noticeMapper.selectAll();
        model.addAttribute(noticeList);

        return "notices/list";
    }
}
