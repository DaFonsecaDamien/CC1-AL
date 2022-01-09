package fr.esgi.al.domain;

public class Skill {
    private final SkillID skillID;
    private final String name;

    public Skill(SkillID skillID, String name) {
        this.skillID = skillID;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                '}';
    }
}
