package org.perscholas.practicetracker.dataEntryForm;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class DataEntryFormBean {

    private Integer id;

    private Integer userId;

    private Integer sessionId;

    private String date;

    private Integer rating;

    private String sessionName;

    private String notes;

    private Integer time;

    private List<String> errorMessages = new ArrayList<>();

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    } //overrides default to string (makes it print nicer)

}
