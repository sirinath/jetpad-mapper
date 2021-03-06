/*
 * Copyright 2012-2015 JetBrains s.r.o
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrains.jetpad.model.property;

import jetbrains.jetpad.model.event.EventHandler;
import jetbrains.jetpad.base.Registration;

public class DelegateProperty<ValueT> implements Property<ValueT> {
  private Property<ValueT> myProperty;

  public DelegateProperty(Property<ValueT> property) {
    myProperty = property;
  }

  @Override
  public ValueT get() {
    return myProperty.get();
  }

  @Override
  public void set(ValueT value) {
    myProperty.set(value);
  }

  @Override
  public Registration addHandler(EventHandler<? super PropertyChangeEvent<ValueT>> handler) {
    return myProperty.addHandler(handler);
  }

  @Override
  public String getPropExpr() {
    return "delegate(" + myProperty + ")";
  }
}