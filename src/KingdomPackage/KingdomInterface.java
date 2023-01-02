package KingdomPackage;

import ArmyPackage.Battalion;
import PersonPackage.Noble;

public interface KingdomInterface {


    public String OrderDeclareWar(Kingdom kingdom);

    public String OrderMakePeace();

    public int OrderBuildAlliance(Kingdom kingdom);

    public boolean collectTaxes();

    public void increaseTaxes(int increaseAmount);

    public void decreaseTaxes(int decreaseAmount);

    public boolean makeFeast();

    public int calculatePopulation();

    public boolean OrderConvertReligion(Religion religionName);

    public boolean sendSpymaster(Kingdom kingdom);

    public boolean orderManageRelations(Kingdom kingdom, boolean increaseOrDecrease);

    public boolean exile(Noble noble);

    public int recruitSoldier(String soldierType, int numberOfBattalions);

    public int produceWeapon(String weaponType, int numberOfWeaponUnit);

    public boolean upgradeSoldierRank(Battalion soldierType);

    public int upgradeStructureRank(String structureType);

    public int constructStructure(String structureType);


}
