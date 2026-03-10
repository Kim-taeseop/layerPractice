package practice.layerPractice.entity.description.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSon is a Querydsl query type for Son
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSon extends EntityPathBase<Son> {

    private static final long serialVersionUID = 71289514L;

    public static final QSon son = new QSon("son");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<Parent, QParent> parents = this.<Parent, QParent>createList("parents", Parent.class, QParent.class, PathInits.DIRECT2);

    public QSon(String variable) {
        super(Son.class, forVariable(variable));
    }

    public QSon(Path<? extends Son> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSon(PathMetadata metadata) {
        super(Son.class, metadata);
    }

}

