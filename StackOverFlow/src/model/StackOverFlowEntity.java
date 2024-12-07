package model;

public abstract class StackOverFlowEntity {

    private Integer id;
    private String description;
    private Integer upVotes;
    private Integer downVotes;

    public StackOverFlowEntity(Integer id, String description) {
        this.id = id;
        this.description = description;
        this.upVotes = 0;
        this.downVotes = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(Integer upVotes) {
        this.upVotes = upVotes;
    }

    public Integer getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(Integer downVotes) {
        this.downVotes = downVotes;
    }

    public void upVote(StackOverFlowEntity stackOverFlowEntity) {
        stackOverFlowEntity.setUpVotes(stackOverFlowEntity.getUpVotes() + 1);
    }

    public void downVote(StackOverFlowEntity stackOverFlowEntity) {
        stackOverFlowEntity.setDownVotes(stackOverFlowEntity.getDownVotes() + 1);
    }
}
