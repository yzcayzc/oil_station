package com.ruoyi.web.controller.member;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.member.domain.MCouponReceiveUse;
import com.ruoyi.member.service.IMCouponReceiveUseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 优惠券领取使用信息Controller
 * 
 * @author ruoyi
 * @date 2020-02-27
 */
@Controller
@RequestMapping("/member/m_coupon_receive_use")
public class MCouponReceiveUseController extends BaseController
{
    private String prefix = "member/m_coupon_receive_use";

    @Autowired
    private IMCouponReceiveUseService mCouponReceiveUseService;

    @RequiresPermissions("member:m_coupon_receive_use:view")
    @GetMapping()
    public String m_coupon_receive_use()
    {
        return prefix + "/m_coupon_receive_use";
    }

    /**
     * 查询优惠券领取使用信息列表
     */
    @RequiresPermissions("member:m_coupon_receive_use:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MCouponReceiveUse mCouponReceiveUse)
    {
        startPage();
        List<MCouponReceiveUse> list = mCouponReceiveUseService.selectMCouponReceiveUseList(mCouponReceiveUse);
        return getDataTable(list);
    }

    /**
     * 导出优惠券领取使用信息列表
     */
    @RequiresPermissions("member:m_coupon_receive_use:export")
    @Log(title = "优惠券领取使用信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MCouponReceiveUse mCouponReceiveUse)
    {
        List<MCouponReceiveUse> list = mCouponReceiveUseService.selectMCouponReceiveUseList(mCouponReceiveUse);
        ExcelUtil<MCouponReceiveUse> util = new ExcelUtil<MCouponReceiveUse>(MCouponReceiveUse.class);
        return util.exportExcel(list, "m_coupon_receive_use");
    }

    /**
     * 新增优惠券领取使用信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存优惠券领取使用信息
     */
    @RequiresPermissions("member:m_coupon_receive_use:add")
    @Log(title = "优惠券领取使用信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MCouponReceiveUse mCouponReceiveUse)
    {
        return toAjax(mCouponReceiveUseService.insertMCouponReceiveUse(mCouponReceiveUse));
    }

    /**
     * 修改优惠券领取使用信息
     */
    @GetMapping("/edit/{couponReceiveUseId}")
    public String edit(@PathVariable("couponReceiveUseId") Long couponReceiveUseId, ModelMap mmap)
    {
        MCouponReceiveUse mCouponReceiveUse = mCouponReceiveUseService.selectMCouponReceiveUseById(couponReceiveUseId);
        mmap.put("mCouponReceiveUse", mCouponReceiveUse);
        return prefix + "/edit";
    }

    /**
     * 修改保存优惠券领取使用信息
     */
    @RequiresPermissions("member:m_coupon_receive_use:edit")
    @Log(title = "优惠券领取使用信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MCouponReceiveUse mCouponReceiveUse)
    {
        return toAjax(mCouponReceiveUseService.updateMCouponReceiveUse(mCouponReceiveUse));
    }

    /**
     * 删除优惠券领取使用信息
     */
    @RequiresPermissions("member:m_coupon_receive_use:remove")
    @Log(title = "优惠券领取使用信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(mCouponReceiveUseService.deleteMCouponReceiveUseByIds(ids));
    }
}