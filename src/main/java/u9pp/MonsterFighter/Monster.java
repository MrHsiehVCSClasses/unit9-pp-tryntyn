package u9pp.MonsterFighter;

public class Monster extends Combatant{
  private int exp;
  
  public Monster(String name, int maxHealth, int attack, int experience){
    super(name, maxHealth,attack);
    exp = experience;
    if(exp < 0){
    exp = 0;
    }

  }
    public int getExpGiven(){
      return exp;
      
    }
  public void getAttacked(int attackPower) {
        super.getAttacked(attackPower);
    }
    public String takeTurn(Combatant target){
        target.getAttacked(this.getAttackPower());
        return this.getName() + "attacked " + target.getName() + " with " + this.getAttackPower();
    }
  
}

