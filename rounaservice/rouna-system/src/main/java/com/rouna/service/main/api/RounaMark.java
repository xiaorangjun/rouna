package com.rouna.service.main.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2017/12/15.
 */
@ApiModel(value = "RounaMark",description = "成绩信息")
public class RounaMark {
    @ApiModelProperty(name = "testId",notes = "考试编号",required = true,example = "000000")
    private String testId;
    @ApiModelProperty(name = "studentId",notes = "学员编号",required = true,example = "000000")
    private String studentId;
    @ApiModelProperty(name = "subjectId",notes = "科目编号",required = true,example = "000000")
    private String subjectId;
    @ApiModelProperty(name = "subjectMark",notes = "科目成绩",required = true,example = "0")
    private int subjectMark;

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public int getSubjectMark() {
        return subjectMark;
    }

    public void setSubjectMark(int subjectMark) {
        this.subjectMark = subjectMark;
    }
}
