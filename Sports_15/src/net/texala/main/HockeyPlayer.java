package net.texala.main;

class HockeyPlayer extends Player {
    private int jerseyno;

    public HockeyPlayer(String name, int jerseyno) {
        super(name, jerseyno);
        this.jerseyno = jerseyno;
    }

    public void play() {
        System.out.println("Hockey Player - " + getName() + " is playing Hockey and Jersey Number is " + jerseyno);
    }
}

