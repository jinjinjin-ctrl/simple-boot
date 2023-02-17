package com.simpleboot.controller;

import com.simpleboot.service.SimpleVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 视频Controller
 *
 * @author administrator
 * @date 2023-02-17
 */
@Controller
@RequestMapping("/simplevideo/video")
public class SimpleVideoController
{
    private String prefix = "simplevideo/video";

    @Autowired
    private SimpleVideoService simpleVideoService;

    @GetMapping()
    public String video()
    {
        return prefix + "/video";
    }

//    /**
//     * 查询视频列表
//     */
//    @PostMapping("/list")
//    @ResponseBody
//    public TableDataInfo list(SimpleVideo simpleVideo)
//    {
//        startPage();
//        List<SimpleVideo> list = simpleVideoService.selectSimpleVideoList(simpleVideo);
//        return getDataTable(list);
//    }
//
//    /**
//     * 导出视频列表
//     */
//    @PostMapping("/export")
//    @ResponseBody
//    public AjaxResult export(SimpleVideo simpleVideo)
//    {
//        List<SimpleVideo> list = simpleVideoService.selectSimpleVideoList(simpleVideo);
//        ExcelUtil<SimpleVideo> util = new ExcelUtil<SimpleVideo>(SimpleVideo.class);
//        return util.exportExcel(list, "video");
//    }
//
//    /**
//     * 新增视频
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存视频
//     */
//    @PostMapping("/add")
//    @ResponseBody
//    public AjaxResult addSave(SimpleVideo simpleVideo)
//    {
//        return toAjax(simpleVideoService.insertSimpleVideo(simpleVideo));
//    }
//
//    /**
//     * 修改视频
//     */
//    @GetMapping("/edit/{videoId}")
//    public String edit(@PathVariable("videoId") Long videoId, ModelMap mmap)
//    {
//        SimpleVideo simpleVideo = simpleVideoService.selectSimpleVideoById(videoId);
//        mmap.put("simpleVideo", simpleVideo);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存视频
//     */
//    @PostMapping("/edit")
//    @ResponseBody
//    public AjaxResult editSave(SimpleVideo simpleVideo)
//    {
//        return toAjax(simpleVideoService.updateSimpleVideo(simpleVideo));
//    }
//
//    /**
//     * 删除视频
//     */
//    @PostMapping( "/remove")
//    @ResponseBody
//    public AjaxResult remove(String ids)
//    {
//        return toAjax(simpleVideoService.deleteSimpleVideoByIds(ids));
//    }

}
