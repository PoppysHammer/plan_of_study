package org.example.demo.design;

/**
 * 装修包接口 定义了填充各项物料的方法：吊顶、涂料、地板、地砖，以及最终提供获取全部明细的方法
 */
public interface IMenu {

    IMenu appendCeiling(Matter matter); //吊顶

    IMenu appendCoat(Matter matter); //涂料

    IMenu appendFloor(Matter matter); //地板

    IMenu appendTile(Matter matter); //地砖

    String getDetail(); //明细
}
