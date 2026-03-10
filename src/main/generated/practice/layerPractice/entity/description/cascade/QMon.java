package practice.layerPractice.entity.description.cascade;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMon is a Querydsl query type for Mon
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMon extends EntityPathBase<Mon> {

    private static final long serialVersionUID = -246399222L;

    public static final QMon mon = new QMon("mon");

    public final ListPath<Child, QChild> childList = this.<Child, QChild>createList("childList", Child.class, QChild.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QMon(String variable) {
        super(Mon.class, forVariable(variable));
    }

    public QMon(Path<? extends Mon> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMon(PathMetadata metadata) {
        super(Mon.class, metadata);
    }

}

