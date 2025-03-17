package com.example.spring.demos.web;

import com.example.spring.service.ShareService;
import com.example.spring.service.interfaces.ShareServiceI;
import com.example.spring.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.pojo.Share;

@CrossOrigin
@RestController
@RequestMapping("/share")
public class ShareController {
    @PostMapping("/paginate")
    public ResultVo Test(int page,int size,String name,boolean isSearch)
    {
        return ShareService.selectAll();
    }
    @PostMapping("/addSharing")
    public ResultVo addSharing(@RequestBody Share share)
    {
        return ShareService.addSharing(share);
    }
}
