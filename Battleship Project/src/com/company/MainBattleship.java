package com.company;

import java.security.PublicKey;

public abstract class MainBattleship {
    public MainBattleship(){}
    public abstract Boolean setShipMap();
    public abstract void getBattleMap();
    public abstract void getShipMap();
    public abstract Boolean attack();
    public abstract Boolean Win();
}
