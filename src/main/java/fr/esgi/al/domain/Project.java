package fr.esgi.al.domain;

public class Project {
    private final ProjectID projectID;
    private final String name;

    public Project(ProjectID projectID, String name) {
        this.projectID = projectID;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }
}
