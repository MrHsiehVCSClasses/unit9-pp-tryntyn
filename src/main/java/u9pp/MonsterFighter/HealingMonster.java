
package u9pp.MonsterFighter;

class HealingMonster extends Monster{
  private int healAmount;
  public HealingMonster(String name, int maxHealth, int attack, int experience, int healing){
    super(name, maxHealth, attack, experience);
    healAmount = healing;
  }
    public int getHealingPerTurn(){
      return healAmount;
    }
      public String takeTurn(Combatant target){
        super.heal(this.getHealingPerTurn());
        target.getAttacked(this.getAttackPower());
        return this.getName() + " attacked " + target.getName() + " with " + this.getAttackPower() + healAmount;
      }
}
