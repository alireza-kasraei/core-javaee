package net.devk.commons.data;

import lombok.Data;

import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

/**
 * Created by sArshad on 3/6/2018.
 */
@Data
public class JoinParamData {

    private final String field;
    private final JoinType joinType;
    private final String parent;

}
