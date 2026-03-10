package practice.layerPractice.sql.sqlEntity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberSQL is a Querydsl query type for MemberSQL
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberSQL extends EntityPathBase<MemberSQL> {

    private static final long serialVersionUID = -185751166L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberSQL memberSQL = new QMemberSQL("memberSQL");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final QTeamSQL teamSQL;

    public QMemberSQL(String variable) {
        this(MemberSQL.class, forVariable(variable), INITS);
    }

    public QMemberSQL(Path<? extends MemberSQL> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberSQL(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberSQL(PathMetadata metadata, PathInits inits) {
        this(MemberSQL.class, metadata, inits);
    }

    public QMemberSQL(Class<? extends MemberSQL> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.teamSQL = inits.isInitialized("teamSQL") ? new QTeamSQL(forProperty("teamSQL")) : null;
    }

}

