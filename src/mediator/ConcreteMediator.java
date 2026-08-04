package mediator;

import java.util.HashMap;

public class ConcreteMediator extends Mediator {

    private HashMap<String, Colleague> colleagueMap;

    private HashMap<String, String> interMap;

    public ConcreteMediator() {
        colleagueMap = new HashMap<>();
        interMap = new HashMap<>();
    }

    @Override
    public void register(String colleagueName, Colleague colleague) {
        colleagueMap.put(colleagueName, colleague);

        if (colleague instanceof Alarm) {
            interMap.put("Alarm", colleagueName);
        } else if (colleague instanceof CoffeeMachine) {
            interMap.put("CoffeeMachine", colleagueName);
        } else if (colleague instanceof TV) {
            interMap.put("TV", colleagueName);
        } else if (colleague instanceof Curtains) {
            interMap.put("Curtains", colleagueName);
        }
    }

    /**
     * 中介者的核心方法
     *  1、根据得到的消息，完成对应的任务。
     *  2、中介者在这个方法，协调各个具体的同事对象，完成任务。
     * @param stateChange
     * @param colleagueName
     */
    @Override
    public void getMessage(int stateChange, String colleagueName) {
        if (colleagueMap.get(colleagueName) instanceof Alarm) {
            if (stateChange == 0) {
                ((CoffeeMachine) colleagueMap.get(interMap.get("CoffeeMachine"))).startCoffee();
                ((TV) colleagueMap.get(interMap.get("TV"))).startTV();
            } else if (stateChange == 1) {
                ((TV) colleagueMap.get(interMap.get("TV"))).stopTV();
            }
        } else if (colleagueMap.get(colleagueName) instanceof CoffeeMachine) {
            ((Curtains) colleagueMap.get(colleagueName)).upCurtains();
        } else if (colleagueMap.get(colleagueName) instanceof TV) {

        } else if (colleagueMap.get(colleagueName) instanceof Curtains) {
            ((Curtains) colleagueMap.get(colleagueName)).upCurtains();
        }

    }

    @Override
    public void sendMessage() {

    }
}
