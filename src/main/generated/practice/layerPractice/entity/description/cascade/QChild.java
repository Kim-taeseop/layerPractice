package practice.layerPractice.entity.description.cascade;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChild is a Querydsl query type for Child
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChild extends EntityPathBase<Child> {

    private static final long serialVersionUID = -575896166L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChild child = new QChild("child");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMon mon;

    public final StringPath name = createString("name");

    public QChild(String variable) {
        this(Child.class, forVariable(variable), INITS);
    }

    public QChild(Path<? extends Child> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChild(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChild(PathMetadata metadata, PathInits inits) {
        this(Child.class, metadata, inits);
    }

    public QChild(Class<? extends Child> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mon = inits.isInitialized("mon") ? new QMon(forProperty("mon")) : null;
    }

}

