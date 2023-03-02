package org.example.demo.design;

import org.example.demo.design.ceilling.LevelOneCeiling;
import org.example.demo.design.ceilling.LevelTwoCeiling;
import org.example.demo.design.coat.DuluxCoat;
import org.example.demo.design.coat.LiBangCoat;
import org.example.demo.design.floor.ShengXiangFloor;
import org.example.demo.design.tile.DongPengTile;
import org.example.demo.design.tile.MarcoPoloTile;

public class Builder {

    public IMenu levelOne(Double area) {
        return new DecorationPackageMenu(area, "豪华欧式").appendCeiling(new LevelTwoCeiling())    // 吊顶，二级顶
                .appendCoat(new DuluxCoat())             // 涂料，多乐士
                .appendFloor(new ShengXiangFloor());     // 地板，圣象
    }

    public IMenu levelTwo(Double area) {
        return new DecorationPackageMenu(area, "轻奢田园").appendCeiling(new LevelTwoCeiling())    // 吊顶，二级顶
                .appendCoat(new LiBangCoat())             // 涂料，立邦
                .appendFloor(new MarcoPoloTile());     // 地砖，马可波罗
    }

    public IMenu levelThree(Double area) {
        return new DecorationPackageMenu(area, "现代简约").appendCeiling(new LevelOneCeiling())    // 吊顶，一级顶
                .appendCoat(new LiBangCoat())             // 涂料，立邦
                .appendFloor(new DongPengTile());     // 地板，东鹏
    }
}
