package com.squareup.sqlbrite2;

import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.RestrictTo;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import java.util.Set;

import static android.support.annotation.RestrictTo.Scope.LIBRARY;

@RestrictTo(LIBRARY)
public final class BriteDatabaseV2Factory {
  private BriteDatabaseV2Factory() {
    throw new AssertionError("No instances");
  }

  public static BriteDatabase create(SqlBrite sqlBrite, SQLiteOpenHelper helper,
      Observable<Set<String>> triggerSource, Observer<Set<String>> triggerSink,
      Scheduler scheduler) {
    return new BriteDatabase(helper, sqlBrite.logger, triggerSource, triggerSink, scheduler,
        sqlBrite.queryTransformer);
  }
}
