package org.perscholas.practicetracker.FollowingFormBean;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter
@Setter
public class FollowingBean {

    private Integer id;

    private Integer userId;

    private Integer followingId;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    } //overrides default to string (makes it print nicer)

}