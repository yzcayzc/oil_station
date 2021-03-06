package com.ruoyi.activity.mapper;

import com.ruoyi.activity.domain.ElectronicCoupons;
import java.util.List;

/**
 * 电子优惠券设置Mapper接口
 * 
 * @author ruoyi
 * @date 2020-02-27
 */
public interface ElectronicCouponsMapper 
{
    /**
     * 查询电子优惠券设置
     * 
     * @param couponsId 电子优惠券设置ID
     * @return 电子优惠券设置
     */
    public ElectronicCoupons selectElectronicCouponsById(Long couponsId);

    /**
     * 查询电子优惠券设置列表
     * 
     * @param electronicCoupons 电子优惠券设置
     * @return 电子优惠券设置集合
     */
    public List<ElectronicCoupons> selectElectronicCouponsList(ElectronicCoupons electronicCoupons);

    /**
     * 新增电子优惠券设置
     * 
     * @param electronicCoupons 电子优惠券设置
     * @return 结果
     */
    public int insertElectronicCoupons(ElectronicCoupons electronicCoupons);

    /**
     * 修改电子优惠券设置
     * 
     * @param electronicCoupons 电子优惠券设置
     * @return 结果
     */
    public int updateElectronicCoupons(ElectronicCoupons electronicCoupons);

    /**
     * 删除电子优惠券设置
     * 
     * @param couponsId 电子优惠券设置ID
     * @return 结果
     */
    public int deleteElectronicCouponsById(Long couponsId);

    /**
     * 批量删除电子优惠券设置
     * 
     * @param couponsIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteElectronicCouponsByIds(String[] couponsIds);
}
