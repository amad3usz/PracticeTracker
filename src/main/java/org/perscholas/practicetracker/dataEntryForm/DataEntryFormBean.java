package org.perscholas.practicetracker.dataEntryForm;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class DataEntryFormBean {

    private Integer id;

    @NotEmpty
    private Integer userId;

    @NotEmpty(message = "Choose a Session Type")
    private Integer sessionId;

    @NotEmpty(message = "Rating is Date")
    private String date;

    @NotEmpty(message = "Rating is required")
    private Integer rating;

    @NotEmpty(message = "Session name is required")
    private String sessionName;


    private String notes;

    @NotEmpty(message = "Time is required")
    private Integer time;

    private List<String> errorMessages = new ArrayList<>();

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    } //overrides default to string (makes it print nicer)

}
