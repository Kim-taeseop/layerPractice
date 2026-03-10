package practice.layerPractice.sql.sqlEntity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTeamSQL is a Querydsl query type for TeamSQL
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTeamSQL extends EntityPathBase<TeamSQL> {

    private static final long serialVersionUID = -395081121L;

    public static final QTeamSQL teamSQL = new QTeamSQL("teamSQL");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<MemberSQL, QMemberSQL> memberSQLList = this.<MemberSQL, QMemberSQL>createList("memberSQLList", MemberSQL.class, QMemberSQL.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public QTeamSQL(String variable) {
        super(TeamSQL.class, forVariable(variable));
    }

    public QTeamSQL(Path<? extends TeamSQL> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTeamSQL(PathMetadata metadata) {
        super(TeamSQL.class, metadata);
    }

}

